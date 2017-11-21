package database;

import constants.Constants;
import entity.Discipline;

import java.util.LinkedList;
import java.util.List;

public class DataService {
    private static Object monitor = new Object();
    private static List<DBConection> pool = new LinkedList<>();

    public void init() {
        for (int i = 0; i < Constants.CONNECTION_POOL_SIZE; i++) {
            this.newConnection();
        }
    }

    private void newConnection() {
        DBConection conection = new DBConection();
        synchronized (monitor) {
            pool.add(conection);
        }
    }

    public DBConection getConnection() {
        synchronized (monitor) {
            if (pool.size() == 0) {
                newConnection();
            }
            return pool.remove(0);
        }
    }

    public void putConnection(DBConection conection) {
        synchronized (monitor) {
            pool.add(conection);
        }
    }

    public List<Discipline> getAllDisciplines() {
        DBConection conection = getConnection();
        List<Discipline> disciplines = conection.getAllDisciplines();
        putConnection(conection);
        return disciplines;
    }
}
