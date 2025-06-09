package com.sist.web.controller;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.*;
import com.sist.web.repository.*;

@RestController
// => Reatful => GET(SELECT 읽기), POST(INSERT 쓰기) , PUT(UPDATE 수정) , DELETE(DELETE 삭제)
@CrossOrigin(origins = "*")
// 1521 / 8080 => AWS는 0~1023까지 port를 접근 거부
public class BoardRestController {
	@Autowired
	private BoardRepository bDao;
	// ResponseEntity<Map>
	@GetMapping("/board/list/{page}")
	public ResponseEntity<Map> board_list(@PathVariable("page") int page) {
		Map map=new HashMap();
		try {
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			List<BoardVO> list=bDao.boardListDate(start,end);
			
			int count=(int)bDao.count();
			int totalpage=(int)(Math.ceil(count/(double)rowSize));
			String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("today", today);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);// 서버측 에러 전송
		}
		return new ResponseEntity<>(map,HttpStatus.OK);// 정상 수행
	}
	@PostMapping("/board/insert")
	public ResponseEntity<Map> board_insert(@RequestBody BoardEntity vo) {
		Map map=new HashMap();
		try {
			vo.setHit(0);
			vo.setNo(bDao.maxNo());
			vo.setRegdate(new Date());
			BoardEntity _vo=bDao.save(vo);
			map.put("vo", _vo);
			map.put("msg", "yes");
		} catch (Exception e) {
			map.put("msg", e.getMessage());
			return new ResponseEntity<Map>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	/*
	 *  	JPA => DataSet => VO를 가지고 데이터베이스 제어
	 *  			|
	 *  			SQL없이 사용이 가능
	 *  	=> 복잡한 쿼리, WHERE (조건문) => 규칙
	 *  	   findByNo(int no) WHERE no=?
	 *  	=> 나머지는 제공하는 메소드 사용
	 *  		= count() SELECT COUNT(*) ~
	 *  		= save() => insert/update
	 *  		= delete()
	 */
	@GetMapping("/board/detail/{no}")
	public ResponseEntity<BoardVO> board_detail(@PathVariable("no") int no) {
		BoardVO vo=null;
		try {
			BoardEntity b=bDao.findByNo(no);
			// 조회수 증가
			b.setHit(b.getHit()+1);
			bDao.save(b);
			vo=bDao.boardDetailData(no);
			System.out.println(3);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
	@DeleteMapping("/board/delete/{no}/{pwd}")
	public ResponseEntity<Map> board_delete(@PathVariable("no") int no, @PathVariable("pwd") String pwd) {
		Map map=new HashMap();
		try {
			BoardEntity vo=bDao.findByNo(no);
			if(vo.getPwd().equals(pwd)) {
				bDao.delete(vo);
				map.put("msg", "yes");
			}else {
				map.put("msg", "no");
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@GetMapping("/board/update/{no}")
	public ResponseEntity<BoardUpdateVO> board_update(@PathVariable("no") int no) {
		BoardUpdateVO vo=null;
		try {
			vo=bDao.boardUpdateData(no);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
	@PutMapping("/board/update_ok")
	public ResponseEntity<Map> board_update_ok(@RequestBody BoardEntity vo) {
		Map map=new HashMap();
		try {
			BoardEntity db=bDao.findByNo(vo.getNo());
			if(vo.getPwd().equals(db.getPwd())) {
				vo.setNo(vo.getNo());
				vo.setHit(db.getHit());
				bDao.save(vo);
				map.put("msg", "yes");
			}else {
				map.put("msg", "no");
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
}
