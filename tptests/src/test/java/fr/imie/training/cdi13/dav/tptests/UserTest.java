package fr.imie.training.cdi13.dav.tptests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class UserTest {

	// @InjectMocks
	// private User user = null;

	@Test
	public void test() {

		IUser user = Mockito.mock(IUser.class);
		Assert.assertNotNull(user);

		Mockito.when(user.getLogin()).thenReturn("Ibra").thenReturn("toto", "tata");

		user.setLogin("Dark");
		Assert.assertEquals("Ibra", user.getLogin());

		user.setLogin("Vador");
		Assert.assertEquals("toto", user.getLogin());
		user.setLogin("Vador");
		Assert.assertEquals("tata", user.getLogin());

	}

	@Test
	public void test2() {

		User user = Mockito.mock(User.class);
		Assert.assertNotNull(user);

		Mockito.when(user.getLogin()).thenCallRealMethod();
		Mockito.doCallRealMethod().when(user).setLogin("Dark");

		user.setLogin("Toto");
		Assert.assertEquals(null, user.getLogin());

		user.setLogin("Dark");
		Assert.assertEquals("Dark", user.getLogin());

	}

	@Test
	public void testSpy() {
		User userSpy = Mockito.spy(User.class);

		userSpy.setLogin("Toto");
		Assert.assertEquals("Toto", userSpy.getLogin());

		Mockito.when(userSpy.getLogin()).thenReturn("Ibra");

		Assert.assertEquals("Ibra", userSpy.getLogin());

	}

	@Test
	public void testVerify() {

		IUser user = Mockito.mock(IUser.class);

		user.setLogin("toto");
		Assert.assertEquals(null, user.getLogin());

		Mockito.verify(user, Mockito.times(1)).getLogin();
		Mockito.verify(user, Mockito.times(1)).setLogin("toto");
		Mockito.verify(user, Mockito.never()).setLogin("");
		Mockito.verify(user, Mockito.times(1)).setLogin(Mockito.anyString());

	}

}
