package macca.demo.services;

import macca.demo.models.Storage;
import macca.demo.repositories.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    public List<Storage> getAllStorages() {
        return storageRepository.findAll();
    }

    public Storage getStorageById(Long id) {
        return storageRepository.findById(id).orElseThrow(() -> new RuntimeException("Storage not found with id" + id));
    }
}
