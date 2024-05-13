package com.homeland.homeland.service.implement;

import com.homeland.homeland.controller.ImageController;
import com.homeland.homeland.model.Image;
import com.homeland.homeland.model.Property;
import com.homeland.homeland.repository.ImageRepository;
import com.homeland.homeland.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final Path root = Paths.get(System.getProperty("user.dir") + "/uploads");

    private final ImageRepository imageRepository;

    @Override
    public void init() {
        try {
            if(!Files.exists(root)) Files.createDirectory(root);
        } catch (IOException exception) {
            throw new RuntimeException("Could not initialize ImageService", exception);
        }
    }

    @Override
    public void save(MultipartFile file, Property property) {
        String fileName = Long.toString(System.currentTimeMillis()).concat(
                file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))
        );

        try {
            Files.copy(file.getInputStream(), this.root.resolve(fileName));
        } catch (IOException exception) {
            throw new RuntimeException("Could not save image", exception);
        }

        imageRepository.save(Image.builder()
                .url(fileName)
                .property(property)
                .build());
    }

    @Override
    public Resource load(String fileName) {
        try {
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable())
                return resource;
            else
                throw new RuntimeException("Could not read file: " + fileName);
        } catch (MalformedURLException exception) {
            throw new RuntimeException("Could not read file: " + fileName, exception);
        }
    }

    @Override
    public List<String> findByPropertyId(Long propertyId) {
        return imageRepository.findByPropertyId(propertyId)
                .stream().map(Image::getUrl).toList();
    }
}
