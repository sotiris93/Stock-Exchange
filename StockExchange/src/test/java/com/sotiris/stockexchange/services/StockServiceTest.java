package com.sotiris.stockexchange.services;

import com.sotiris.stockexchange.model.Stock;
import com.sotiris.stockexchange.repositories.StockRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StockServiceTest {

    //    @Mock
    private StockRepository stockRepository = new StockRepository() {
        @Override
        public void flush() {

        }

        @Override
        public <S extends Stock> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Stock> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Stock> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Stock getOne(Long aLong) {
            return null;
        }

        @Override
        public Stock getById(Long aLong) {
            return null;
        }

        @Override
        public Stock getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Stock> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Stock> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends Stock> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<Stock> findAll() {
            return List.of(new Stock("EUR", "A"), new Stock("USD", "B"));
        }

        @Override
        public List<Stock> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Stock> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Stock> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Stock entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Stock> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<Stock> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<Stock> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Stock> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Stock> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Stock> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Stock> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Stock, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };


    private StockService stockService = new StockService(stockRepository);

    @Test
    void shouldReturnAllStocks() {
        List<Stock> mockStocks = List.of(new Stock("EUR", "A"), new Stock("USD", "B"));

//        when(stockRepository.findAll()).thenReturn(mockStocks);

//        assertThrows(NoSuchElementException.class, () -> stockService.getStocks());
        assertEquals(List.of(Stock.builder().currency("123").build()), stockService.getStocks());


    }
//
//    @Test()
//    void shouldThrowException() {
//        when(stockRepository.findAll()).thenReturn(Collections.emptyList());
////        assertEquals("Exception Message", exception.getMessage());
//    }


}