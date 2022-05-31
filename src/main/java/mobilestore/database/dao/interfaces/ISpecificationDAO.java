package mobilestore.database.dao.interfaces;



import mobilestore.database.models.Specification;

public interface ISpecificationDAO extends IBaseDAO<Specification>{
    void showAllSpecifications();
}
