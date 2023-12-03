package np.com.sagarbhusal01.BackEnd.Repositories;

import np.com.sagarbhusal01.BackEnd.DataModels.APIdataModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface APIdataSQLRepository extends JpaRepository<APIdataModel,Integer> {
    public List<APIdataModel> findByHospitalid(String hospitalid);
}
