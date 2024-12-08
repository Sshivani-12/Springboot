package com.luv2code.springboot.cruddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private AssetRepository assetRepository;

    @PostMapping("/upload")
    @PreAuthorize("hasRole('ADMIN')") // Only ADMIN role can upload
    public ResponseEntity<Asset> uploadFile(@RequestParam("file") MultipartFile file,
                                            @RequestParam("name") String name,
                                            @RequestParam("description") String description,
                                            @RequestParam("tags") String tags) {
        String filePath = fileStorageService.storeFile(file);

        Asset asset = new Asset();
        asset.setName(name);
        asset.setDescription(description);
        asset.setFilePath(filePath);
        asset.setTags(tags);

        assetRepository.save(asset);
        return ResponseEntity.ok(asset);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')") // User and Admin roles can view
    public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
        return assetRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Asset>> searchAssets(@RequestParam("tag") String tag) {
        List<Asset> assets = assetRepository.findByTagsContaining(tag);
        return ResponseEntity.ok(assets);
    }
}
