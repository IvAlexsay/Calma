package ivakin.first.my_first_app

object TimeData {
    var inhale: Int = 4
    var hold: Int = 7
    var exhale: Int = 8
    var loops: Int = 4
    fun setFSE(){
        this.inhale = 4
        this.hold = 7
        this.exhale = 8
        this.loops = 4
    }
    fun setFFF(){
        this.inhale = 4
        this.hold = 4
        this.exhale = 4
        this.loops = 4
    }
    fun setCUSTOM(inhale: Int, hold: Int, exhale: Int, countLoops: Int){
        this.inhale = inhale
        this.hold = hold
        this.exhale = exhale
        this.loops = countLoops
    }
}