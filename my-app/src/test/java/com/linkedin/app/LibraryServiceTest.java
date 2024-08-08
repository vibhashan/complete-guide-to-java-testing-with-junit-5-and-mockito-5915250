package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

  private static final String BOOK_TITLE = "Java Programming";
  private static final int QUANTITY = 5;
  private static final String MEMBER_ID = "MEM001";
  private static final String MEMBER_NAME = "John Doe";

  @InjectMocks
  private LibraryService underTest;

  @Mock
  private LibraryRepository libraryRepository;

  @Test
  public void addBook() {
    underTest.addBook(BOOK_TITLE, QUANTITY);
    verify(libraryRepository).addBook(BOOK_TITLE, QUANTITY);
  }

  @Test
  public void lendBook_withValidMember() {
    underTest.registerMember(MEMBER_ID, MEMBER_NAME);
    when(libraryRepository.lendBook(BOOK_TITLE)).thenReturn(true);
    boolean result = underTest.lendBook(BOOK_TITLE, MEMBER_ID);
    assertTrue(result);
    verify(libraryRepository).lendBook(BOOK_TITLE);
  }

  @Test
  public void lendBook_withInvalidMember() {
    assertFalse(underTest.lendBook(BOOK_TITLE, MEMBER_ID));
    verify(libraryRepository, never()).lendBook(BOOK_TITLE);
  }

  @Test
  public void registerMember() {
    underTest.registerMember(MEMBER_ID, MEMBER_NAME);
    assertTrue(underTest.getMembers().containsKey(MEMBER_ID));
    assertEquals(MEMBER_NAME, underTest.getMembers().get(MEMBER_ID).getName());
  }

}
