package mobilestore.database.dao.interfaces;


import mobilestore.database.models.Processor;

public interface IProcessorDAO extends IBaseDAO<Processor> {
    void showAllProcessors ();
}
