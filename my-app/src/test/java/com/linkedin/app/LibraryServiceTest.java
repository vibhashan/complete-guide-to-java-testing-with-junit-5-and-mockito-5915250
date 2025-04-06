package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {
    @Mock
    private static LibraryRepository mockRepo;

    @InjectMocks
    private static LibraryService libraryService;

    private static Member member;
    private static final String BOOK_TITLE = "Test Title 1";
    private static final int QUANTITY = 5;

    @BeforeAll
    static void beforeAll() {
        member = new Member("M001", "Jonathan");
    }

    @AfterAll
    static void afterAll() {
        member = null;
    }

    @Test
    void addBook() {
        doNothing().when(mockRepo).addBook(BOOK_TITLE, QUANTITY);

        libraryService.addBook(BOOK_TITLE, QUANTITY);
        verify(mockRepo).addBook(BOOK_TITLE, QUANTITY);
    }

    @Test

    void registerMember() {
        libraryService.registerMember(member.getMemberId(), member.getName());

        assertFalse(libraryService.getMembers().isEmpty());
    }

    @Test

    void getMembers() {
        assertFalse(libraryService.getMembers().isEmpty());
        assertInstanceOf(Member.class, libraryService.getMembers().get(member.getMemberId()));
        assertEquals(member.getName(), libraryService.getMembers().get(member.getMemberId()).getName());
    }

    @Test

    void lendBookForExistingMember() {
        when(mockRepo.lendBook(BOOK_TITLE)).thenReturn(true);

        assertTrue(libraryService.lendBook(BOOK_TITLE, member.getMemberId()));

        verify(mockRepo).lendBook(BOOK_TITLE);
    }

    @Test
    void lendBookForNonExistingMember() {
        assertFalse(libraryService.lendBook(BOOK_TITLE, "NONEXISTING " + Math.random() * 100));
        verify(mockRepo, never()).lendBook(BOOK_TITLE);
    }

}
