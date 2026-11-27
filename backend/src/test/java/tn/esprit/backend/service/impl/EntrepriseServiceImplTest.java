package tn.esprit.backend.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.backend.entity.Entreprise;
import tn.esprit.backend.repository.EntrepriseRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EntrepriseServiceImplTest {

    @Mock
    private EntrepriseRepository entrepriseRepository;

    @InjectMocks
    private EntrepriseServiceImpl entrepriseService;

    @Test
    void testAddEntreprise() {
        Entreprise entreprise = new Entreprise();

        when(entrepriseRepository.save(entreprise)).thenReturn(entreprise);

        Entreprise result = entrepriseService.addEntreprise(entreprise);

        assertNotNull(result);
        assertSame(entreprise, result);
        verify(entrepriseRepository).save(entreprise);
    }

    @Test
    void testUpdateEntreprise() {
        Entreprise entreprise = new Entreprise();

        when(entrepriseRepository.save(entreprise)).thenReturn(entreprise);

        Entreprise result = entrepriseService.updateEntreprise(entreprise);

        assertNotNull(result);
        assertSame(entreprise, result);
        verify(entrepriseRepository).save(entreprise);
    }

    @Test
    void testDeleteEntreprise() {
        Long id = 1L;

        entrepriseService.deleteEntreprise(id);

        verify(entrepriseRepository).deleteById(id);
    }

    @Test
    void testGetEntrepriseByIdFound() {
        Long id = 1L;
        Entreprise entreprise = new Entreprise();

        when(entrepriseRepository.findById(id))
                .thenReturn(Optional.of(entreprise));

        Entreprise result = entrepriseService.getEntrepriseById(id);

        assertNotNull(result);
        assertSame(entreprise, result);
        verify(entrepriseRepository).findById(id);
    }

    @Test
    void testGetEntrepriseByIdNotFound() {
        Long id = 99L;

        when(entrepriseRepository.findById(id))
                .thenReturn(Optional.empty());

        Entreprise result = entrepriseService.getEntrepriseById(id);

        assertNull(result);
        verify(entrepriseRepository).findById(id);
    }

    @Test
    void testGetAllEntreprises() {
        List<Entreprise> entreprises = List.of(
                new Entreprise(),
                new Entreprise()
        );

        when(entrepriseRepository.findAll()).thenReturn(entreprises);

        List<Entreprise> result = entrepriseService.getAllEntreprises();

        assertEquals(2, result.size());
        assertSame(entreprises, result);
        verify(entrepriseRepository).findAll();
    }
}
