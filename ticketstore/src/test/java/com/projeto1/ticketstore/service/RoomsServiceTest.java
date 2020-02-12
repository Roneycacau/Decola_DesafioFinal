package com.projeto1.ticketstore.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.projeto1.ticketstore.domain.entities.Rooms;
import com.projeto1.ticketstore.exception.DataNotFoundException;
import com.projeto1.ticketstore.repository.RoomsRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RoomsServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private RoomsRepository repositoryMock;

    @InjectMocks
    private RoomsService service;

    Rooms entity = Rooms.builder()//
            .id(1)//
            .rowNum(1)//
            .colNum(1)//
            .build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {
        // given no data
        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Sala não encontrada");
        // when
        service.findById(1);
    }

    @Test
    public void should_findById() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        // when
        Rooms model = service.findById(anyInt());
        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Sala deve ser encontrado!", model);
    }

    @Test
    public void should_ListOneItem() {
        List<Rooms> list = new ArrayList<>();
        list.add(entity);
        // given
        when(repositoryMock.findAll()).thenReturn(list);
        // when
        List<Rooms> listR = service.listRooms();
        // then
        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }

}