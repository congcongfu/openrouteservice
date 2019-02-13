package heigit.ors.routing;

import com.graphhopper.GHResponse;
import com.graphhopper.PathWrapper;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Polygon;
import heigit.ors.api.requests.common.APIEnums;
import heigit.ors.api.requests.routing.*;
import heigit.ors.common.DistanceUnit;
import heigit.ors.exceptions.IncompatibleParameterException;
import heigit.ors.exceptions.ParameterValueException;
import heigit.ors.routing.graphhopper.extensions.VehicleLoadCharacteristicsFlags;
import heigit.ors.routing.graphhopper.extensions.WheelchairTypesEncoder;
import heigit.ors.routing.parameters.VehicleParameters;
import heigit.ors.routing.parameters.WheelchairParameters;
import heigit.ors.routing.pathprocessors.BordersExtractor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RouteResultBuilderTest {
    RouteRequest request;


    public RouteResultBuilderTest() throws Exception {
        init();
    }

    @Before
    public void init() throws Exception {
        Double[][] coords = new Double[3][2];
        coords[0] = new Double[] {24.5,39.2};
        coords[1] = new Double[] {27.4,38.6};
        coords[2] = new Double[] {26.5,37.2};
        request = new RouteRequest(coords);

        request.setProfile(APIEnums.Profile.DRIVING_CAR);
        request.setAttributes(new APIEnums.Attributes[] { APIEnums.Attributes.AVERAGE_SPEED, APIEnums.Attributes.DETOUR_FACTOR});
        request.setExtraInfo(new APIEnums.ExtraInfo[] { APIEnums.ExtraInfo.OSM_ID});
        request.setIncludeGeometry(true);
        request.setIncludeInstructionsInResponse(true);
        request.setIncludeRoundaboutExitInfo(true);
        request.setIncludeManeuvers(true);
        request.setInstructionsFormat(APIEnums.InstructionsFormat.HTML);
        request.setLanguage(APIEnums.Languages.DE);
        request.setUseElevation(true);
        request.setRoutePreference(APIEnums.RoutePreference.FASTEST);

        RouteRequestOptions options = new RouteRequestOptions();
        options.setAvoidBorders(APIEnums.AvoidBorders.CONTROLLED);
        request.setRouteOptions(options);
    }

    @Ignore("WIP") @Test
    public void TestWheelchairParameters() throws Exception {
        List<GHResponse> responseList = new ArrayList<>();
        GHResponse response = new GHResponse();
        PathWrapper path = new PathWrapper();
        path.setPoints()
        response.add(path);
        responseList.add(response);

        RoutingRequest routingRequest = new RouteRequestHandler().convertRouteRequest(request);

        List<RouteExtraInfo> extrasList = new ArrayList<>();

        RouteResultBuilder builder = new RouteResultBuilder();
        RouteResult result = builder.createMergedRouteResultFromBestPaths(responseList, routingRequest, extrasList);
        Assert.assertEquals(0, result);
    }
}
