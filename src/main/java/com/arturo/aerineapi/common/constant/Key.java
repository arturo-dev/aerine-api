package com.arturo.aerineapi.common.constant;

public final class Key {
    
    public final class Security {
        public static final String OPERATION_NOT_SECURE = "Operation.NotSecure";

        private Security() {}
    }
    
    public final class Validation {
    	public static final String PLAYER_REQUIRED = "Player.Required";
    	public static final String PLAYER_INVALID_LEVEL = "Player.Invalid.Level";
    	
    	private Validation() {}
    }

    private Key() {}
}