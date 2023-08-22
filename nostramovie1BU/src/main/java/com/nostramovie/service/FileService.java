package com.nostramovie.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.nostramovie.models.FileModel;
import com.nostramovie.repositories.FileRepository;

@Service
public class FileService {
	
	private final FileRepository fileRepository;
	
	@Autowired
	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}
	
	 public void save(MultipartFile file,String MovieName,String description, double rating
			 ) throws IOException {
	        FileModel fileEntity = new FileModel();
	        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
	        fileEntity.setContentType(file.getContentType());
	        fileEntity.setData(file.getBytes());
	        fileEntity.setSize(file.getSize());
	        fileEntity.setMovieName(MovieName);
	        fileEntity.setDescription(description);
	        fileEntity.setRating(rating);

	        fileRepository.save(fileEntity);
	    }
	 
	 public Optional<FileModel> getFile(String id) {
	        return fileRepository.findById(id);
	    }

	    public List<FileModel> getAllFiles() {
	        return fileRepository.findAll();
	    }


}
