
package tn.esprit.backend.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.backend.entity.Entreprise;
import tn.esprit.backend.entity.Equipe;
import tn.esprit.backend.entity.Projet;
import tn.esprit.backend.repository.EntrepriseRepository;
import tn.esprit.backend.repository.EquipeRepository;
import tn.esprit.backend.repository.ProjetRepository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EquipeServiceImplTest {

    @Mock
    private EquipeRepository equipeRepository;

    @Mock
    private EntrepriseRepository entrepriseRepository;

    @Mock
    private ProjetRepository projetRepository;

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Test
    void testAddEquipe() {
        Equipe equipe = new Equipe();
        when(equipeRepository.save(equipe)).thenReturn(equipe);

        Equipe result = equipeService.addEquipe(equipe);

        assertSame(equipe, result);
        verify(equipeRepository).save(equipe);
    }

    @Test
    void testUpdateEquipe() {
        Equipe equipe = new Equipe();
        when(equipeRepository.save(equipe)).thenReturn(equipe);

        Equipe result = equipeService.updateEquipe(equipe);

        assertSame(equipe, result);
        verify(equipeRepository).save(equipe);
    }

    @Test
    void testDeleteEquipe() {
        Long id = 1L;

        equipeService.deleteEquipe(id);

        verify(equipeRepository).deleteById(id);
    }

    @Test
    void testGetEquipeByIdFound() {
        Long id = 1L;
        Equipe equipe = new Equipe();

        when(equipeRepository.findById(id))
                .thenReturn(Optional.of(equipe));

        Equipe result = equipeService.getEquipeById(id);

        assertSame(equipe, result);
        verify(equipeRepository).findById(id);
    }

    @Test
    void testGetEquipeByIdNotFound() {
        Long id = 99L;

        when(equipeRepository.findById(id))
                .thenReturn(Optional.empty());

        Equipe result = equipeService.getEquipeById(id);

        assertNull(result);
        verify(equipeRepository).findById(id);
    }

    @Test
    void testGetAllEquipes() {
        List<Equipe> equipes = List.of(
                new Equipe(),
                new Equipe()
        );

        when(equipeRepository.findAll()).thenReturn(equipes);

        List<Equipe> result = equipeService.getAllEquipes();

        assertEquals(2, result.size());
        assertSame(equipes, result);
        verify(equipeRepository).findAll();
    }

    @Test
    void testGetEquipesByEntreprise() {
        Long entrepriseId = 1L;
        List<Equipe> equipes = List.of(new Equipe());

        when(equipeRepository.findByEntrepriseId(entrepriseId))
                .thenReturn(equipes);

        List<Equipe> result =
                equipeService.getEquipesByEntreprise(entrepriseId);

        assertEquals(1, result.size());
        assertSame(equipes, result);
        verify(equipeRepository).findByEntrepriseId(entrepriseId);
    }

    @Test
    void testAssignEquipeToEntreprise() {
        Long equipeId = 1L;
        Long entrepriseId = 2L;

        Equipe equipe = new Equipe();
        Entreprise entreprise = new Entreprise();

        when(equipeRepository.findById(equipeId))
                .thenReturn(Optional.of(equipe));

        when(entrepriseRepository.findById(entrepriseId))
                .thenReturn(Optional.of(entreprise));

        when(equipeRepository.save(equipe)).thenReturn(equipe);

        Equipe result =
                equipeService.assignEquipeToEntreprise(equipeId, entrepriseId);

        assertSame(equipe, result);
        assertSame(entreprise, equipe.getEntreprise());
        verify(equipeRepository).save(equipe);
    }

    @Test
    void testAssignEquipeToProjet() {
        Long equipeId = 1L;
        Long projetId = 2L;

        Equipe equipe = new Equipe();
        equipe.setProjets(new ArrayList<>());

        Projet projet = new Projet();

        when(equipeRepository.findById(equipeId))
                .thenReturn(Optional.of(equipe));

        when(projetRepository.findById(projetId))
                .thenReturn(Optional.of(projet));

        when(equipeRepository.save(equipe)).thenReturn(equipe);

        Equipe result =
                equipeService.assignEquipeToProjet(equipeId, projetId);

        assertSame(equipe, result);
        assertTrue(equipe.getProjets().contains(projet));
        verify(equipeRepository).save(equipe);
    }
}
