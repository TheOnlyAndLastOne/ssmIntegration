package com.own.mvcmybatis.controller;

import com.own.mvcmybatis.dao.QueryVo;
import com.own.mvcmybatis.exception.MessageException;
import com.own.mvcmybatis.pojo.Items;
import com.own.mvcmybatis.service.ItemService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @Author: zhaozhi
 * @Date: 2018/8/23 0023 15:47
 * @Description: 商品管理
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    //商品列表
    @RequestMapping(value="/item/itemlist.action")
    public ModelAndView itemList(){
        // 创建页面需要显示的商品数据
        List<Items> list = itemService.selectItemsList();
        ModelAndView mv = new ModelAndView();
        mv.addObject("itemList",list);
        mv.setViewName("itemList");
        return mv;
    }

    //修改页面
    @RequestMapping(value="/itemEdit.action")
    public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Items items = itemService.selectItemsById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("item",items);
        mv.setViewName("editItem");
        return mv;
    }

    @RequestMapping(value="/updateitem.action")
    public String updateitem(Items items,MultipartFile pictureFile,HttpServletRequest request) throws Exception{
    //public ModelAndView updateitem(QueryVo queryVo,MultipartFile pictureFile) throws IOException {
        if(pictureFile.getSize()==0){
            throw new MessageException("照片为空");
        }

        //保存图片
        String name = UUID.randomUUID().toString().replaceAll("-","");
        //jpg
        String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());

        File dir = new File("D:\\upload\\" +request.getContextPath()+"\\"+"itemPic");
        if(!dir.exists()){
            dir.mkdirs();
        }
        pictureFile.transferTo(new File(dir+"\\"+ name+"."+ext));

        items.setPic(request.getContextPath()+"\\"+"itemPic"+"\\"+ name+"."+ext);

        //Items items = queryVo.getItem();
        itemService.updateitem(items);
       /* ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        return mv;*/
        return "redirect:/itemEdit.action?id=" + items.getId();
    }

    @RequestMapping("/json.action")
    @ResponseBody
    public Items json(@RequestBody Items items){
        return items;
    }

}
