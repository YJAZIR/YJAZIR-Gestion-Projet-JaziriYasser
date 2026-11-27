
package tn.esprit.backend.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.backend.entity.Projet;
import tn.esprit.backend.entity.ProjetDetaille;
import tn.esprit.backend.repository.ProjetDetailleRepository;
import tn.esprit.backend.repository.ProjetRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjetDetailleServiceImplTest {

    @Mock
    private ProjetDetailleRepository projetDetailleRepository;

    @Mock
    private ProjetRepository projetRepository;

    @InjectMocks
    private ProjetDetailleServiceImpl projetDetailleService;

    @Test
    void testAddProjetDetaille() {
        ProjetDetaille detaille = new ProjetDetaille();

        when(projetDetailleRepository.save(detaille)).thenReturn(detaille);

        ProjetDetaille result =
                projetDetailleService.addProjetDetaille(detaille);

        assertNotNull(result);
        assertSame(detaille, result);
        verify(projetDetailleRepository).save(detaille);
    }

    @Test
    void testUpdateProjetDetaille() {
        ProjetDetaille detaille = new ProjetDetaille();

        when(projetDetailleRepository.save(detaille)).thenReturn(detaille);

        ProjetDetaille result =
                projetDetailleService.updateProjetDetaille(detaille);

        assertNotNull(result);
        assertSame(detaille, result);
        verify(projetDetailleRepository).save(detaille);
    }

    @Test
    void testDeleteProjetDetaille() {
        Long id = 1L;

        projetDetailleService.deleteProjetDetaille(id);

        verify(projetDetailleRepository).deleteById(id);
    }

    @Test
    void testGetProjetDetailleByIdFound() {
        Long id = 1L;
        ProjetDetaille detaille = new ProjetDetaille();

        when(projetDetailleRepository.findById(id))
                .thenReturn(Optional.of(detaille));

        ProjetDetaille result =
                projetDetailleService.getProjetDetailleById(id);

        assertNotNull(result);
        assertSame(detaille, result);
        verify(projetDetailleRepository).findById(id);
    }

    @Test
    void testGetProjetDetailleByIdNotFound() {
        Long id = 99L;

        when(projetDetailleRepository.findById(id))
                .thenReturn(Optional.empty());

        ProjetDetaille result =
                projetDetailleService.getProjetDetailleById(id);

        assertNull(result);
        verify(projetDetailleRepository).findById(id);
    }

    @Test
    void testGetAllProjetsDetailles() {
        ProjetDetaille detaille1 = new ProjetDetaille();
        ProjetDetaille detaille2 = new ProjetDetaille();

        when(projetDetailleRepository.findAll())
                .thenReturn(Arrays.asList(detaille1, detaille2));

        var result = projetDetailleService.getAllProjetsDetailles();

        assertEquals(2, result.size());
        verify(projetDetailleRepository).findAll();
    }

    @Test
    void testGetProjetDetaillesByProjet() {
        Long projetId = 1L;
        ProjetDetaille detaille = new ProjetDetaille();

        when(projetDetailleRepository.findByProjetId(projetId))
                .thenReturn(Collections.singletonList(detaille));

        var result =
                projetDetailleService.getProjetDetaillesByProjet(projetId);

        assertEquals(1, result.size());
        assertSame(detaille, result.get(0));
        verify(projetDetailleRepository).findByProjetId(projetId);
    }

    @Test
    void testAssignProjetDetailleToProjet() {
        Long detailleId = 1L;
        Long projetId = 2L;

        ProjetDetaille detaille = new ProjetDetaille();
        Projet projet = new Projet();

        when(projetDetailleRepository.findById(detailleId))
                .thenReturn(Optional.of(detaille));

        when(projetRepository.findById(projetId))
                .thenReturn(Optional.of(projet));

        when(projetDetailleRepository.save(detaille))
                .thenReturn(detaille);

        ProjetDetaille result =
                projetDetailleService.assignProjetDetailleToProjet(
                        detailleId, projetId);

        assertNotNull(result);
        assertSame(projet, detaille.getProjet());
        assertSame(detaille, result);

        verify(projetDetailleRepository).findById(detailleId);
        verify(projetRepository).findById(projetId);
        verify(projetDetailleRepository).save(detaille);
    }
}
