package fpt.onthijava6.service;

import fpt.onthijava6.dto.BaiHatCustom;
import fpt.onthijava6.dto.BaiHatDTO;
import fpt.onthijava6.entity.BaiHat;
import fpt.onthijava6.repository.BaiHatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BaiHatService {

    @Autowired
    private BaiHatRepository baiHatRepository;

    public List<BaiHatDTO> getAllBaiHat(){
        return baiHatRepository.findAllBaiHats();
    }

    public Page<BaiHatDTO> getBaiHatByPage( Integer page){
        Pageable pageable = PageRequest.of(0,5);
        return baiHatRepository.findAllBaiHatPhanTrang(pageable);
    }

    public BaiHat add(BaiHatCustom request){
        BaiHat baiHat = request.dtoToBaiHat(new BaiHat());
        return baiHatRepository.save(baiHat);
    }

    public BaiHat update(Long id, BaiHatCustom request){
        BaiHat bh = baiHatRepository.findById(id).orElse(null);
        if(bh ==null) return null;

        request.dtoToBaiHat(bh);
        return baiHatRepository.save(bh);
    }

    public BaiHat findById(Long id){return baiHatRepository.findById(id).orElse(null);}

    public List<BaiHatDTO> getFemaleBaiHat(){
        return baiHatRepository.getFemaleCaSi();
    }


    public BaiHatDTO timNgayRaMatLauNhatLaNu(){
        List<BaiHatDTO> result = baiHatRepository.timBanNuLonTuoiNhat(PageRequest.of(0,1));
        return result.isEmpty()?null:result.get(0);
    }

    public Map<Integer,List<BaiHatDTO>> nhomTheoThangRaMatVaSapXep(){
        return baiHatRepository.findAllOrderByNgayBaiHatAnd().stream()
                .collect(Collectors.groupingBy(b -> b.getNgayRaMat().getMonthValue()));
    }
}
