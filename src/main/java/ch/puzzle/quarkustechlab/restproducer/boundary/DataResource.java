package ch.puzzle.quarkustechlab.restproducer.boundary;

import ch.puzzle.quarkustechlab.reactiveproducer.boundary.ReactiveDataProducer;
import ch.puzzle.quarkustechlab.restproducer.entity.SensorMeasurement;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/data")
@RequestScoped
public class DataResource {

    @Inject
    ReactiveDataProducer reactiveDataProducer;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SensorMeasurement getSensorMeasurement() {
        reactiveDataProducer.sendMessage();
        return new SensorMeasurement();
    }
}