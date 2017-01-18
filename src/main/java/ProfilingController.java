
public class ProfilingController implements ProfilingControllerMBean {

	public boolean profilingEnabled = true;

	public boolean isProfilingEnabled() {
		return profilingEnabled;
	}

	@Override
	public void setProfilingEnabled(boolean profilingEnabled) {
		this.profilingEnabled = profilingEnabled;
	}
	
}
