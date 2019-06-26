package ru.example.democlient.service;

import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public interface CellService {

    HashSet<Cell> getNextGeneration();
}
