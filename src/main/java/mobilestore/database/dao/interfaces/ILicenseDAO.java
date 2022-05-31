package mobilestore.database.dao.interfaces;

import mobilestore.database.models.License;

public interface ILicenseDAO extends IBaseDAO<License> {
    void showAllLicenses ();
}
