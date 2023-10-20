package Repository;

import DataAccess.AnalysisStringDAO;

public class AnalysisStringRepository implements IAnalysisStringRepository{

    @Override
    public void analysisString() {
        AnalysisStringDAO.Instance().analysisString();
    }
           
}