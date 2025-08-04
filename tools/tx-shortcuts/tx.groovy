/*
 * TX Shortcuts - Simple transmission commands
 * 
 * This script provides short commands for sending frames.
 * 
 * USAGE: Upload to scripts folder and load with 'tx' command in shell
 */

import org.arl.unet.phy.*

// CONTROL frame commands
c = { Object... args ->
    if (args.length == 0) {
        phy << new TxFrameReq(type: Physical.CONTROL)
        println "CONTROL frame sent (broadcast)"
    } else if (args.length == 1) {
        phy << new TxFrameReq(type: Physical.CONTROL, to: args[0])
        println "CONTROL frame sent to node ${args[0]}"
    } else if (args.length == 2) {
        phy << new TxFrameReq(type: Physical.CONTROL, to: args[0], data: args[1])
        println "CONTROL frame sent to node ${args[0]} with data: ${args[1]}"
    }
}

// DATA frame commands
d = { Object... args ->
    if (args.length == 0) {
        phy << new TxFrameReq(type: Physical.DATA)
        println "DATA frame sent (broadcast)"
    } else if (args.length == 1) {
        phy << new TxFrameReq(type: Physical.DATA, to: args[0])
        println "DATA frame sent to node ${args[0]}"
    } else if (args.length == 2) {
        phy << new TxFrameReq(type: Physical.DATA, to: args[0], data: args[1])
        println "DATA frame sent to node ${args[0]} with data: ${args[1]}"
    }
}

println "TX Shortcuts loaded!"
println ""
println "COMMANDS:"
println "  c()              - Send CONTROL frame (broadcast)"
println "  c(4)             - Send CONTROL frame to node 4"  
println "  c(4, [1,2,3])    - Send CONTROL frame to node 4 with data"
println "  d()              - Send DATA frame (broadcast)"
println "  d(4)             - Send DATA frame to node 4"
println "  d(4, [1,2,3])    - Send DATA frame to node 4 with data"
println ""
