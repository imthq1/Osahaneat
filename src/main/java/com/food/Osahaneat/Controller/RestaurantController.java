package com.food.Osahaneat.Controller;


import com.food.Osahaneat.payLoad.ResponseDate;
import com.food.Osahaneat.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    FileService fileService;


    @PostMapping()
    public ResponseEntity<?> createRestaurant(@RequestParam MultipartFile file){
        ResponseDate responseDate = new ResponseDate();
        boolean isSuccess =fileService.saveFile(file);
        responseDate.setData(isSuccess);
        return new ResponseEntity<>(responseDate, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        Resource file=fileService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);

    }
}
