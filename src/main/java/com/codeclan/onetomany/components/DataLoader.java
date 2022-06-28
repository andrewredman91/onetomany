package com.codeclan.onetomany.components;

import com.codeclan.onetomany.models.File;
import com.codeclan.onetomany.models.Folder;
import com.codeclan.onetomany.models.Person;
import com.codeclan.onetomany.repository.FileRepository;
import com.codeclan.onetomany.repository.FolderRepository;
import com.codeclan.onetomany.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){}


    public void run(ApplicationArguments args) throws Exception {

        Person person1 = new Person("Eric");
        personRepository.save(person1);

        Person person2 = new Person("Blobby");
        personRepository.save(person2);

        Folder folder = new Folder("this folder", person1);
        folderRepository.save(folder);

        File file = new File("This file", ".txt", 1, folder);
        fileRepository.save(file);

    }
}