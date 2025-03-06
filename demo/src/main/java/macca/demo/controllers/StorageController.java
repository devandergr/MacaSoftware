package macca.demo.controllers;

import macca.demo.models.Storage;
import macca.demo.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/all")
    public ResponseEntity<List<Storage>> getAllStorages() {
        return ResponseEntity.ok(storageService.getAllStorages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Storage> getStorageById(@PathVariable Long id) {
        Storage storage = storageService.getStorageById(id);
        return ResponseEntity.ok(storage);
    }
}
