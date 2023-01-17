package com.example.Cocktail_Recipe.repository;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.Cocktail_Recipe.domain.Recipe;
import com.example.Cocktail_Recipe.domain.Recipe_detail;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JdbcRecipeRepository implements RecipeRepository {

	private final JdbcTemplate jdbcTem;
	private final Gson gson;
	
	@Autowired
	public JdbcRecipeRepository(DataSource dataSource) 
	{
		jdbcTem = new JdbcTemplate(dataSource);
		gson = new Gson();
	}
	
	@Override
	public Optional<Recipe> findByid(long id)
	{
		List<Recipe> result = jdbcTem.query("select * from recipes where id = ?", RecipeRowMapper(), id);
		for (Recipe recipe : result) {
			log.info(recipe.toString());
		}
		return result.stream().findAny();
	}
	
	@Override
	public List<Recipe> findAll() {
		// TODO Auto-generated method stub
		return jdbcTem.query("select * from recipes", RecipeRowMapper());
	}
	
	private Recipe_detail JsonDetailToObj(String jsonstr) 
	{
		Recipe_detail detail = gson.fromJson(jsonstr, Recipe_detail.class);
		return detail;
	}
	
	private RowMapper<Recipe> RecipeRowMapper()
	{
		return (rs, rowNum) -> {
			Recipe recipe = new Recipe();
			recipe.setId(rs.getInt("id"));
			recipe.setDrinkName(rs.getString("drinkName"));
			recipe.setDrinkImgDirUUID(rs.getString("drinkImgsDirUUID"));
			recipe.setRecipeDetail(JsonDetailToObj(rs.getString("Json_RecipeDetail")));
			return recipe;
		};
	}

	@Override
	public Optional<Recipe> findByidAndName(long id, String drinkName) {
		// TODO Auto-generated method stub
		List<Recipe> result = jdbcTem.query("select * from recipes where id = ? and drinkName = ?"
				, RecipeRowMapper(), id, drinkName);
		for (Recipe recipe : result) {
			log.info(recipe.toString());
		}
		return result.stream().findAny();
	}

	@Override
	public void createRecipe(String cockTailName, String UUID, String json, String userid, String userpw) {
		// TODO Auto-generated method stub
		jdbcTem.update("insert into recipes"
				+ "(drinkName, drinkImgsDirUUID, Json_RecipeDetail, userid, userpw)"
				+ "values(?,?,?,?,?)",cockTailName,UUID,json,userid,userpw);
	}

	@Override
	public void UpdateRecipe(long id, String cockTailName, String json) {
		// TODO Auto-generated method stub
		jdbcTem.update("update recipes set "
				+ "drinkName = ?, Json_RecipeDetail = ? "
				+ "where id = ?",cockTailName,json,id);
	}
	
	@Override
	public void deleteRecipe(long id) {
		// TODO Auto-generated method stub
		jdbcTem.update("delete from recipes where id = ?",id);
	}

	@Override
	public boolean AuthRecipe(long id, String userid, String userpw) {
		// TODO Auto-generated method stub
		List<Recipe> result = jdbcTem.query
				("select * from recipes where " + 
				 "id = ? and userid = ? and userpw = ?",
				  RecipeRowMapper(),id,userid,userpw);
		
		if(result.size() <= 0) {
			return false;
		}
		
		return true;
	}
	
}
