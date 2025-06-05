package com.sist.web.service;
import java.util.*;

import com.sist.web.entity.*;
public interface RecipeService {
	public List<RecipeVO> recipeListData(Integer start,Integer end);
	public int recipeTotalPage();
	public Map recipeDetailData(int no);
	public Map recipeFindData(int page,String title);
}
