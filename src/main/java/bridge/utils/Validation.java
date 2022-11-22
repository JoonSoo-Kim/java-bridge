package bridge.utils;


import static bridge.utils.Constants.*;

public class Validation {
    public void validateInteger(String stringValueIsInteger){
        if(stringValueIsInteger.charAt(0) < '0' || stringValueIsInteger.charAt(0) > '9')
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_NOT_INTEGER);
    }

    public void validateNonZero(int bridgeSize){
        if(bridgeSize == 0)
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_IS_ZERO);
    }

    public void validateBridgeSizeInRange3to20(int bridgeSize){
        if(bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE){
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_NOT_IN_RANGE);
        }
    }



    public void validatePlayerMove(String playerMove){
        if(playerMove != UP_BLOCK && playerMove != DOWN_BLOCK){
            throw new IllegalArgumentException(ERROR_PLAYER_MOVE_IS_NOT_U_OR_D);
        }
    }

    public void validateRestart(String playerRestart){
        if(playerRestart != PLAYER_RETRY && playerRestart != PLAYER_QUIT){
            throw new IllegalArgumentException(ERROR_PLAYER_RESTART_IS_NOT_R_OR_Q);
        }
    }
}
