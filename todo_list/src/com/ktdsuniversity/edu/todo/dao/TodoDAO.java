package com.ktdsuniversity.edu.todo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.todo.vo.TodoVO;

public class TodoDAO {

	//공유메모리 static에서 개수 count
	private static int count = 1;
	
	private Map<Integer, TodoVO> dataSource;

	public TodoDAO() {
		dataSource = new HashMap<>();
	}	
	//등록
	public int create(String itemName) {
		dataSource.put(count++, new TodoVO(itemName));
		return 1;
	}
	//조회(1건)
	public TodoVO read(int number) {
		//map: key를 주면 value를 return
		return dataSource.get(number);
	}
	//조회(모든 건)
	public List<TodoVO> readAll() {
		//map에서 value만 꺼내 list로 변경 (stream)
		return dataSource.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
	}
	//수정
	public int update(int key, boolean isSuccess) {
		TodoVO todoVO = dataSource.get(key);
		todoVO.setSuccess(isSuccess);
		return 1;
	}
	//삭제(1건)
	public int delete(int key) {
		dataSource.remove(key);
		return 1;
	}
	//삭제(모든 건)
	public int deleteAll() {
		int size = dataSource.size();
		dataSource.clear();
		return size;
	}
}
