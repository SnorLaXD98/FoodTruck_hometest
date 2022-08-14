package com.sbs.foodtruck2.Controller;

import com.mysql.cj.protocol.x.Notice;
import com.sbs.foodtruck2.DTO.NoticeDTO;
import com.sbs.foodtruck2.Mapper.TruckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class NoticeController {

    @Autowired
    private TruckMapper truckMapper;

    @GetMapping("/notice/all")
    public List<NoticeDTO> findAllNotice(){

        List<NoticeDTO> notices = truckMapper.findAllNotice();

        return notices;
    }


    @PostMapping("/notice/add")
    public void insertNotice(@RequestBody NoticeDTO noticeDTO){
        System.out.println(noticeDTO.toString());
        truckMapper.insertNotice(noticeDTO);
    }

    @GetMapping("/notice/sort")
    public List<NoticeDTO> noticeSort(){
            List<NoticeDTO> notices = truckMapper.sortNotice();
        return notices;
    }

    @DeleteMapping("/notice/delete/{noticeId}")
    public void deleteNotice(@PathVariable int noticeId){
        truckMapper.deleteNotice(noticeId);
    }

    @GetMapping("/notice/search/{noticeId}")
    public NoticeDTO searchNotice(@PathVariable int noticeId){
        return truckMapper.searchNotice(noticeId);
    }

    @PatchMapping("/notice/modify")
    public void modifyNotice (@RequestBody NoticeDTO noticeDTO){
        truckMapper.modifyNotice(noticeDTO);
    }

}
