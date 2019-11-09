package com.iot.iot_date_interface2.service;

import com.iot.iot_date_interface2.dao.BeamDao;
import com.iot.iot_date_interface2.entity.Beam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeamService {
    @Autowired
    private BeamDao beamDao;


    public List<Beam> getAll(){
        List<Beam> beams = beamDao.selectAll();
        return beams;
    }

    public boolean add(Beam beam){
        Boolean res = beamDao.insert(beam);
        return res;
    }

    public List<Beam> getByAK(String ak){
        List<Beam> beams = beamDao.selectByAK(ak);
        return beams;
    }
}
