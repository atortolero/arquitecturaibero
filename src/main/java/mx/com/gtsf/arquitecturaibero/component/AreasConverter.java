package mx.com.gtsf.arquitecturaibero.component;

import mx.com.gtsf.arquitecturaibero.entity.Areas;
import mx.com.gtsf.arquitecturaibero.model.AreasModel;
import org.springframework.stereotype.Component;

@Component("areasConverter")
public class AreasConverter {

    public AreasModel convertAreasToAreasModel(Areas area){
        AreasModel model = new AreasModel();

        model.setAreaid(area.getAreaid());
        model.setArea(area.getArea());
        model.setColor(area.getColor());

        return model;
    }

    public Areas convertAreasModelToAreas(AreasModel model){
        Areas area = new Areas();

        if(model.getAreaid() > 0){
            area.setAreaid(model.getAreaid());
        }

        area.setArea(model.getArea());
        area.setColor(model.getColor());

        return area;
    }
}
