package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.Planes;
import mx.com.gtsf.arquitecturaibero.model.PlanModel;
import mx.com.gtsf.arquitecturaibero.model.PlanesModel;

import java.util.List;

public interface PlanesService {

    public abstract List<PlanesModel> getAllPlanes();

    public abstract PlanModel savePlan(PlanModel model);
    public abstract int removePlan(long planid);

    public abstract PlanModel getPlanesById(long planid);

    public abstract Planes getPlanesEntityById(long planid);
}
