package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Goods;
import com.example.demo.service.ICardService;

@RestController  // 相当于Controller+ResponseBody
@RequestMapping("/card")
@CrossOrigin(allowCredentials="true", allowedHeaders="*")
public class GoodsController {

	@Autowired
	private ICardService cardService;
	
	@RequestMapping(path = "/listgoods",method = {RequestMethod.POST,RequestMethod.GET})
	public List<Goods> showGoodsList() {
		return cardService.listGoods();
	}
	
	@RequestMapping(path = "/querygoods",method = {RequestMethod.POST,RequestMethod.GET})
	public Goods queryByGoodsId(Integer goodsId) {
		return cardService.queryByGoodsId(goodsId);
	}
}
