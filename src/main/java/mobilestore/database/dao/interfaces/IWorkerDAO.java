package mobilestore.database.dao.interfaces;

import mobilestore.database.models.Worker;

public interface IWorkerDAO extends IBaseDAO<Worker>{
    void showAllWorkers();
}
