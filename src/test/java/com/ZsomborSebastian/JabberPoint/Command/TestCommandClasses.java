package com.ZsomborSebastian.JabberPoint.Command;

import com.ZsomborSebastian.JabberPoint.Accessor.XMLAccessor;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import com.ZsomborSebastian.JabberPoint.Presentation.Presentation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCommandClasses {

  Presentation mockPresentation;

  @BeforeEach
  public void setup() {
    mockPresentation = mock(Presentation.class);
  }

  @AfterEach
  public void teardown() {
    mockPresentation = null;
  }

  @Test
  public void testSaveCommand() {
    // Arrange
    XMLAccessor mockXMLAccessor = mock(XMLAccessor.class);
    SaveCommand cmd = new SaveCommand(mockPresentation, "test.xml");

    // Act
    cmd.execute();
  }

  @Test
  public void testLoadCommand() {
    // Arrange
    XMLAccessor mockXMLAccessor = mock(XMLAccessor.class);
    LoadCommand cmd = new LoadCommand(mockPresentation, "test.xml");

    // Act
    cmd.execute();
  }

  @Test
  public void testClearCommandPresentationNotNull() {
    // Arrange
    ClearCommand cmd = new ClearCommand(mockPresentation);

    // Act and Assert
    try {
      cmd.execute();
    } catch (IllegalArgumentException e) {
      fail("Presentation is null");
    }

    // Assert
    verify(mockPresentation).resetPresentation();
  }

  @Test
  public void testClearCommandPresentationNull() {
    // Arrange
    ClearCommand cmd = new ClearCommand(null);

    // Act & Assert: IllegalArgumentException is thrown
    assertThrows(
            IllegalArgumentException.class,
            new Executable() {
              public void execute() {
                cmd.execute();
              }
            });
  }

  @Test
  public void testGoToCommand() {
    // Arrange
    int slideToGo = 2;
    GoToCommand cmd = new GoToCommand(mockPresentation, slideToGo);

    // Control the behavior of the mock object
    when(mockPresentation.getSlideNumber()).thenReturn(1);
    doNothing().when(mockPresentation).setSlideNumber(anyInt()); // add this line

    // Act
    cmd.execute();

    // Assert
    verify(mockPresentation).setSlideNumber(slideToGo - 1);
  }
  // Tests for ExitCommand might be tricky due to System.exit() call. Skipping the example for that.
}