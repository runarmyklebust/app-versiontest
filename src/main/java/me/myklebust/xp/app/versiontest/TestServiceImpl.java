package me.myklebust.xp.app.versiontest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enonic.xp.node.FindNodesByQueryResult;
import com.enonic.xp.node.NodeQuery;
import com.enonic.xp.node.NodeService;

@Component(immediate = true)
public class TestServiceImpl
    implements TestService
{
    private NodeService nodeService;

    private final Logger LOG = LoggerFactory.getLogger( TestServiceImpl.class );

    // Not really needed, but this will be invoked when every dependency is resolved
    @Activate
    public void initialize()
    {
        LOG.info( "Activating" );
        LOG.info( String.format( "NodeService: %s", this.nodeService ) );
        testStuff();
    }

    @Override
    public void testStuff()
    {
        final FindNodesByQueryResult result = this.nodeService.findByQuery( NodeQuery.create().build() );
        LOG.info( String.format( "Found: %s nodes", result.getHits() ) );
    }

    @Reference
    public void setNodeService( final NodeService nodeService )
    {
        this.nodeService = nodeService;
    }
}
