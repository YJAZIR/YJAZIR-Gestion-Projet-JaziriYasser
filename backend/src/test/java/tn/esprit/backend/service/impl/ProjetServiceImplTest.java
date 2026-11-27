
package tn.esprit.backend.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.backend.entity.Projet;
import tn.esprit.backend.repository.ProjetRepository;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjetServiceImplTest {

    @Mock
    private ProjetRepository projetRepository;

    @InjectMocks
    private ProjetServiceImpl projetService;

    @Test
    void testAddProjet() {
        Projet projet = new Projet();

        when(projetRepository.save(projet)).thenReturn(projet);

        Projet result = projetService.addProjet(projet);

        assertNotNull(result);
        assertSame(projet, result);
        verify(projetRepository).save(projet);
    }

    @Test
    void testUpdateProjet() {
        Projet projet = new Projet();

        when(projetRepository.save(projet)).thenReturn(projet);

        Projet result = projetService.updateProjet(projet);

        assertNotNull(result);
        assertSame(projet, result);
        verify(projetRepository).save(projet);
    }

    @Test
    void testDeleteProjet() {
        Long id = 1L;

        projetService.deleteProjet(id);

        verify(projetRepository).deleteById(id);
    }

    @Test
    void testGetProjetByIdFound() {
        Long id = 1L;
        Projet projet = new Projet();

        when(projetRepository.findById(id))
                .thenReturn(Optional.of(projet));

        Projet result = projetService.getProjetById(id);

        assertNotNull(result);
        assertSame(projet, result);
        verify(projetRepository).findById(id);
    }

    @Test
    void testGetProjetByIdNotFound() {
        Long id = 99L;

        when(projetRepository.findById(id))
                .thenReturn(Optional.empty());

        Projet result = projetService.getProjetById(id);

        assertNull(result);
        verify(projetRepository).findById(id);
    }

    @Test
    void testGetAllProjets() {
        Projet projet1 = new Projet();
        Projet projet2 = new Projet();

        when(projetRepository.findAll())
                .thenReturn(Arrays.asList(projet1, projet2));

        var result = projetService.getAllProjets();

        assertEquals(2, result.size());
        assertSame(projet1, result.get(0));
        assertSame(projet2, result.get(1));
        verify(projetRepository).findAll();
    }
}
