package bridge.domain;

import bridge.view.InputView;

import static bridge.utils.Constants.*;
import static java.lang.System.exit;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    Player player;
    Bridge bridge;
    int bridgeSize;
    int blockNumber;
    InputView inputView;

    public BridgeGame(int bridgeSize){
        player = new Player();
        bridge = new Bridge(bridgeSize);
        this.bridgeSize = bridgeSize;
        blockNumber = 0;
        inputView = new InputView();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        player.MoveTo(inputView.readMoving());
        if(!player.isSuccess(bridge, blockNumber))
            retry();

        blockNumber++;
        if(bridgeSize == blockNumber)
            success();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String playerRetry = inputView.readGameCommand();
        if(playerRetry == PLAYER_RETRY){
            player = new Player();
            blockNumber = 0;
        }
        if(playerRetry == PLAYER_QUIT){
            System.out.println("종료");
            exit(0);
        }
    }

    public void success(){
        System.out.println("성공");
        exit(0);
    }
}
