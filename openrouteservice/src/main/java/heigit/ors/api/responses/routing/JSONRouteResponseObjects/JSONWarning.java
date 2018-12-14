/*
 * This file is part of Openrouteservice.
 *
 * Openrouteservice is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, see <https://www.gnu.org/licenses/>.
 */

package heigit.ors.api.responses.routing.JSONRouteResponseObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import heigit.ors.routing.RouteWarning;
import io.swagger.annotations.ApiModelProperty;

public class JSONWarning {
    @ApiModelProperty(value = "Identification code for the warning")
    @JsonProperty
    private Integer code;

    @ApiModelProperty( value = "The message associated with the warning")
    @JsonProperty
    private String message;

    public JSONWarning(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public JSONWarning(RouteWarning warning) {
        this.code = warning.getWarningCode();
        this.message = warning.getWarningMessage();
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
