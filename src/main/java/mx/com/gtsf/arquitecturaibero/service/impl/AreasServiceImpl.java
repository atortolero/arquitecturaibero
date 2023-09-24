package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.component.AreasConverter;
import mx.com.gtsf.arquitecturaibero.entity.Areas;
import mx.com.gtsf.arquitecturaibero.model.AreasModel;
import mx.com.gtsf.arquitecturaibero.repository.AreasJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.AreasService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("areasServiceImpl")
public class AreasServiceImpl implements AreasService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AreasServiceImpl.class);

    @Autowired
    @Qualifier("areasJpaRepository")
    AreasJpaRepository areasJpaRepository;

    @Autowired
    @Qualifier("areasConverter")
    AreasConverter areasConverter;

    @Override
    public List<AreasModel> getAllAreas() {
        List<AreasModel> areasModel = new ArrayList<AreasModel>();

        List<Areas> areas = areasJpaRepository.findAllByOrderByArea();

        for(Areas area : areas){
            AreasModel model = areasConverter.convertAreasToAreasModel(area);

            areasModel.add(model);
        }

        return areasModel;
    }

    @Transactional
    @Override
    public AreasModel addArea(AreasModel model) {

        Areas area = areasConverter.convertAreasModelToAreas(model);
        area = areasJpaRepository.save(area);

        model = areasConverter.convertAreasToAreasModel(area);

        return model;
    }

    @Transactional
    @Override
    public int removeArea(long areaid) {

        areasJpaRepository.deleteById(areaid);

        return 0;
    }

    @Override
    public Areas getAreaById(long areaid) {
        try {
            Areas area = areasJpaRepository.getAreasByAreaid(areaid);
            return area;
        }catch(Exception e){
            return null;
        }
    }


}
