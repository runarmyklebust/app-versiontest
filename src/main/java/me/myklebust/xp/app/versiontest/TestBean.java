package me.myklebust.xp.app.versiontest;


import com.enonic.xp.script.bean.BeanContext;
import com.enonic.xp.script.bean.ScriptBean;

public class TestBean
    implements ScriptBean
{

    private TestService testService;

    @Override
    public void initialize( final BeanContext context )
    {
        this.testService = context.getService( TestService.class ).get();
    }

    public Object execute()
    {
        this.testService.testStuff();
        return "fisk";
    }
}
