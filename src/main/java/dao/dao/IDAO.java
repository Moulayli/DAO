package dao.dao;

import java.util.List;

public interface IDAO<T> {
	public T create(T t);
	public List<T> readAll();
	public T read(Integer id);
	public void update(T t);
	public void delete(T t);
}
