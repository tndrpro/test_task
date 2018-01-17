package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestngListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		printMessage("[TEST START]", result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		printMessage("[TEST SUCCESS]", result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		printMessage("[TEST FAILURE]", result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		printMessage("[TEST SKIP]", result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		printMessage("[TEST FAILURE]", result);
	}

	@Override
	public void onStart(ITestContext context) {
		printMessage("[START]", context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		printMessage("[FINISH]", context.getName());
	}

	private void printMessage(String prefix, ITestResult result) {
		log.info(prefix + " " + result.getMethod().getDescription());
	}
	
	private void printMessage(String prefix, String name) {
		log.info(prefix + " " + name);
	}

}
