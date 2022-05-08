package com.example.monastery.service;

import com.example.monastery.dao.model.House;
import com.example.monastery.dao.model.News;
import com.example.monastery.dao.repository.HouseRepository;
import com.example.monastery.dao.repository.NewsRepository;
import com.example.monastery.properties.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {
    private final Path rootLocation;

    public NewsService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private HouseRepository houseRepository;

    public News getById(Long id){
        return newsRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    public List<News> getAllNews(){
        return newsRepository.findAll().stream().sorted().collect(Collectors.toList());
    }

    public List<News> getNewsByHouse(Long id){
        House house = houseRepository.findById(id).orElseThrow(RuntimeException::new);
        return newsRepository.findAllByHouse(house).stream().sorted().collect(Collectors.toList());
    }
    public void delete(Long id){
        News news = getById(id);
        newsRepository.delete(news);
    }
    public void save(News news, MultipartFile file){
       news.setImageLocation(store(file));
       save(news);
    }
    public void save(News news){
        news.setDate(LocalDateTime.now());
        newsRepository.save(news);
    }

    public boolean isExist(Long id) {
        return newsRepository.existsById(id);
    }
    public String store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new RuntimeException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
                return rootLocation.getFileName()+file.getOriginalFilename();

            }
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to store file.", e);
        }
    }

}
