Test with Mockito in a spring application.<br/>
This example uses a simple @SpyBean.<br/>
<br/>
compile & test :<br/>
mvn spring-boot:run<br/>
or<br/>
mvn test<br/>

<br/>
--HelloRepositoryImpl.java<br/>
public String get() {<br/>
&nbsp;&nbsp;return "Hello from HelloRepository";<br/>
<br/>
--HelloServiceImpl.java<br/>
@Autowired<br/>
HelloRepository helloRepository;<br/>
@Override<br/>
public String get() {<br/>
&nbsp;&nbsp;return helloRepository.get();<br/>
<br/>
--HelloServiceMockTest.java<br/>
<b>@SpyBean</b>
private HelloRepository helloRepository;<br/>
<b>@InjectMocks</b>
private HelloService helloService = new HelloServiceImpl();<br/>
@Test<br/>
void testReturnedValueWithoutAnyMockingWithMockito() {<br/>
&nbsp;&nbsp;//Arrange<br/>
&nbsp;&nbsp;//  nothing to arrange...<br/>
&nbsp;&nbsp;//Act<br/>
&nbsp;&nbsp;String actualValue = <b>helloService.get();</b><br/>
&nbsp;&nbsp;//Assert<br/>
&nbsp;&nbsp;String expectedValue = "Hello from HelloRepository";<br/>
&nbsp;&nbsp;<b>assertEquals(expectedValue, actualValue);</b><br/>
<br/>
@Test<br/>
void testNumberOfCallsWithMockito() {<br/>
&nbsp;&nbsp;//Arrange<br/>
&nbsp;&nbsp;//  nothing to arrange...<br/>
&nbsp;&nbsp;//Act<br/>
&nbsp;&nbsp;<b>helloService.get();</b><br/>
&nbsp;&nbsp;//Assert<br/>
&nbsp;&nbsp;<b>Mockito.verify(helloRepository, Mockito.times(1)).get();</b><br/>
<br/>
