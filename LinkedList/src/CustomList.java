public interface CustomList<T> {
    public void put(T data);
    public void delete(T data);
    public void replicate(int n);
    public void traverseList();
    public int size();
}
